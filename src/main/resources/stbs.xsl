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
				<xsl:call-template name='dateformat'>
					<xsl:with-param name='date' select='stb:date' />
				</xsl:call-template>
			</xsl:element>
			<xsl:element name='stb:description'>
				<xsl:value-of select='stb:description' />
			</xsl:element>
		</xsl:element>
    </xsl:template>
	

	<xsl:template name='dateformat'>
		<xsl:param name='date' />
		<xsl:variable name='dd' select='substring($date,0,2)' />
		<xsl:variable name='yyyy' select='substring($date,1,4)' />
		<xsl:variable name='mm' select='substring($date,6,2)' />

		<xsl:value-of select='$dd' />
		<xsl:choose>
			<xsl:when test="$mm = '01'">
				Janv
			</xsl:when>
			<xsl:when test="$mm = '02'">
				Févr
			</xsl:when>
			<xsl:when test="$mm = '03'">
				Mars
			</xsl:when>
			<xsl:when test="$mm = '04'">
				Avri
			</xsl:when>
			<xsl:when test="$mm = '05'">
				Mai
			</xsl:when>
			<xsl:when test="$mm = '06'">
				Juin
			</xsl:when>
			<xsl:when test="$mm = '07'">
				Juil
			</xsl:when>
			<xsl:when test="$mm = '08'">
				Août
			</xsl:when>
			<xsl:when test="$mm = '09'">
				Sept
			</xsl:when>
			<xsl:when test="$mm = '10'">
				Octo
			</xsl:when>
			<xsl:when test="$mm = '11'">
				Nove
			</xsl:when>
			<xsl:when test="$mm = '12'">
				Déce
			</xsl:when>
		</xsl:choose>
		<xsl:text></xsl:text>
		<xsl:value-of select='$yyyy' />
	</xsl:template>

	
</xsl:stylesheet>