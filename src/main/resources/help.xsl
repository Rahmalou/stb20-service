<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:stb="http://univ.fr/stb20" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" omit-xml-declaration="yes"/>
	<xsl:strip-space elements="*" />
    <xsl:template match="stb:project">
       <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
       <xsl:element name="html">
       		<xsl:attribute name="lang">fr</xsl:attribute>
       
       		<xsl:element name="head">
		    	<xsl:element name="title">Aide </xsl:element>
		    	<xsl:element name="style">table,th,td{border: 1px solid black;} </xsl:element>
		    </xsl:element>
		    <xsl:element name="body">
		    	<xsl:element name="h1">Liste des commandes</xsl:element>
		    	<xsl:element name="table">
		    		<xsl:attribute name="BORDER">1</xsl:attribute>
		    		<xsl:attribute name="ALIGN">CENTER</xsl:attribute>
			    	<xsl:element name="tr">
						<xsl:element name="th">URL</xsl:element>
						<xsl:element name="th">Méthode</xsl:element>
						<xsl:element name="th">Description</xsl:element>
					</xsl:element>
			    	<xsl:apply-templates select="./stb:command" />
		     	</xsl:element>
		    </xsl:element>
		    
       </xsl:element>
	  	
    </xsl:template >
    
    
    <xsl:template match="stb:command">
    	<xsl:element name="tr">
    		<xsl:element name="td">
    			<xsl:value-of select="stb:url"/>
    		</xsl:element>
    		
    		<xsl:element name="td">
    			<xsl:value-of select="stb:method"/>
    		</xsl:element>
    		
    		<xsl:element name="td">
    			<xsl:value-of select="stb:description"/>
    		</xsl:element>
    		
    	</xsl:element>
    </xsl:template>	
  
</xsl:stylesheet>