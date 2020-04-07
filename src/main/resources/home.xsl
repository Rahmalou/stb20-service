<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:stb="http://univ.fr/stb20" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" omit-xml-declaration="yes"/>
	<xsl:strip-space elements="*" />
    <xsl:template match="stb:project">
       <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
       <xsl:element name="html">
       		<xsl:attribute name="lang">fr</xsl:attribute>
       		<xsl:element name="head">
		    	<xsl:element name="title">Accueil </xsl:element>
		    </xsl:element>
		    <xsl:element name="body">
		    	<xsl:element name="h1">Nom du projet : <xsl:value-of select="stb:name"/></xsl:element>
		    	<xsl:element name="h1">Version : <xsl:value-of select="stb:version"/></xsl:element>
		    	<xsl:element name="h3">Auteurs : <xsl:apply-templates select="./stb:author" /></xsl:element>
		    	<xsl:element name="h3">Date de dernière mise à jour : 
		    		 <xsl:call-template name="getDate">
		    		 	<xsl:with-param name="date" select="stb:date" />
		    		 </xsl:call-template>
		    	</xsl:element>
		    	<xsl:element name="img">
					<xsl:attribute name="src">
					    <xsl:value-of select="stb:image"/>
					</xsl:attribute>
					<xsl:attribute name="width">600</xsl:attribute>
					<xsl:attribute name="height">300</xsl:attribute>
					<xsl:attribute name="alt">
					    <xsl:value-of select="stb:alt"/>
					</xsl:attribute>
				</xsl:element>
		    </xsl:element>
		    
       </xsl:element>
	  	
    </xsl:template >
    
    <xsl:template match="stb:author">
       <xsl:if test="position() >1"> | </xsl:if>
       <xsl:value-of select="stb:firstname"/> <xsl:text> </xsl:text><xsl:value-of select="stb:lastname"/>
    </xsl:template>
    
     <xsl:template name="getDate">
    	<xsl:param name="date" />
    	<xsl:variable name="day" select="substring($date,9, 2)"/>
    	<xsl:variable name="month" select="substring($date,6, 2)"/>
    	<xsl:variable name ="year" select="substring($date,1, 4)" />
    	<xsl:variable name="monthTranslated">
    		<xsl:call-template name="get-month">
                  <xsl:with-param name="month" select="$month" />
              </xsl:call-template>
    	</xsl:variable>
    	<xsl:value-of select="concat($day, ' ', $monthTranslated, ' ',  $year)"/>
    </xsl:template>
    
    <xsl:template name="get-month">
    	<xsl:param name="month" />
        <xsl:choose>
            <xsl:when test="$month = '01'">Janvier</xsl:when>
            <xsl:when test="$month = '02'">Février</xsl:when>
            <xsl:when test="$month = '03'">Mars</xsl:when>
            <xsl:when test="$month = '04'">Avril</xsl:when>
            <xsl:when test="$month = '05'">Mai</xsl:when>
            <xsl:when test="$month = '06'">Juin</xsl:when>
            <xsl:when test="$month = '07'">Juillet</xsl:when>
            <xsl:when test="$month = '08'">Août</xsl:when>
            <xsl:when test="$month = '09'">Septembre</xsl:when>
            <xsl:when test="$month = '10'">Octobre</xsl:when>
            <xsl:when test="$month = '11'">Novembre</xsl:when>
            <xsl:when test="$month = '12'">Décembre</xsl:when>
            <xsl:otherwise>error: <xsl:value-of select="$month"/></xsl:otherwise>
        </xsl:choose>

	</xsl:template>
    

  
</xsl:stylesheet>