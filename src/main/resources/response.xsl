<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:stb="http://univ.fr/stb20" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" omit-xml-declaration="yes"/>
	<xsl:strip-space elements="*" />
    <xsl:template match="stb:response">
       <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
       <xsl:element name="html">
       		<xsl:attribute name="lang">fr</xsl:attribute>
       
       		<xsl:element name="head">
		    	<xsl:element name="title">Réponse</xsl:element>
		    </xsl:element>
		    <xsl:element name="body">
		    	<xsl:element name="h1">Identifiant : <xsl:value-of select="stb:id"/></xsl:element>
		    	<xsl:element name="h1">Status : <xsl:value-of select="stb:status"/></xsl:element>
		    	<xsl:element name="p">Description : <xsl:value-of select="stb:description"/></xsl:element>
		    </xsl:element>
		    
       </xsl:element>
	  	
    </xsl:template >
  
</xsl:stylesheet>