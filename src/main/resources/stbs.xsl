<?xml version='1.0' encoding='UTF-8' ?>
<xsl:stylesheet version="3.0" xmlns:xsl='http://www.w3.org/1999/XSL/Transform' xmlns:stb='http://univ.fr/stb20'>

	<xsl:template match='/stb:stbs'>
		<xsl:element name="stb:stbs">
			<xsl:apply-templates select="./stb:stb" />
		</xsl:element>
	</xsl:template>

	<xsl:template match="stb:stb">
		<xsl:element name="stb:stb">
	    	<xsl:element name='stb:id'>
				<xsl:value-of select='stb:id' />
			</xsl:element>
			<xsl:element name='stb:title'>
				<xsl:value-of select='stb:title' />
			</xsl:element>
			<xsl:element name='stb:version'>
				<xsl:value-of select='stb:version' />
			</xsl:element>
			<xsl:element name='stb:date'>
				<xsl:value-of select='stb:date' />
			</xsl:element>
			<xsl:element name='stb:description'>
				<xsl:value-of select='stb:description' />
			</xsl:element>
		</xsl:element>
    </xsl:template>

	
</xsl:stylesheet>