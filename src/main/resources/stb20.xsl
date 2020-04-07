<?xml version='1.0' encoding='UTF-8' ?>
<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform' xmlns:stb='http://univ.fr/stb20'>

	<xsl:output method='html' version='4.0' doctype-public='-//W3C//DTD. HTML 4.01 Transitional//EN' encoding='UTF-8' indent='yes' />

	<xsl:template match='/stb:stb'>
	   <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
       <xsl:element name="html">
       		<xsl:attribute name="lang">fr</xsl:attribute>
			<xsl:element name='head'>
				<xsl:element name='title'>
					document
				</xsl:element>
				<xsl:element name='style'>
					.role { padding-left: 40px !important; } .gris { background-color: #80808091; }
				</xsl:element>
			</xsl:element>
			<xsl:element name='body'>
				<xsl:element name='h1'>
					STB20 - XSLT V1.0
				</xsl:element>
				<xsl:element name='p'>
					RAHMANI Lounis (Le 07 Avril 2020)
				</xsl:element>
				<xsl:call-template name='title'></xsl:call-template>
				<xsl:call-template name='client'></xsl:call-template>
				<xsl:call-template name='team'></xsl:call-template>
				<xsl:call-template name='detail'></xsl:call-template>

			</xsl:element>
		</xsl:element>
	</xsl:template>
	<xsl:template name='title'>
		<xsl:element name='h2'>
			<xsl:value-of select='stb:title' />
		</xsl:element>
		
		<xsl:element name='h2'>
			Id:
			<xsl:value-of select='stb:id' />
		</xsl:element>
		
		<xsl:element name='p'>
			(V
			<xsl:value-of select='stb:version' />
			-
			<xsl:call-template name='dateformat'>
				<xsl:with-param name='date' select='stb:date' />
			</xsl:call-template>
			)
		</xsl:element>
		<xsl:element name='p'>
			<xsl:value-of select='stb:description' />
		</xsl:element>
	</xsl:template>

	<xsl:template name='client'>
		<xsl:element name='h2'>
			Client
		</xsl:element>
		<xsl:element name='p'>
			<xsl:value-of select='stb:client/stb:entity' />
		</xsl:element>
		<xsl:element name='p'>
			contact:
			<xsl:value-of select='stb:client/stb:firstname' />
			<xsl:text></xsl:text>
			<xsl:value-of select='stb:client/stb:lastname' />
		</xsl:element>
		<xsl:element name='ul'>
			<xsl:for-each select='stb:client/stb:mail'>
				<xsl:element name='li'>
					mail:
					<xsl:value-of select='text()' />
				</xsl:element>
			</xsl:for-each>
			<xsl:for-each select='stb:client/stb:tel'>
				<xsl:element name='li'>
					tel:
					<xsl:call-template name='telephoneFormat'>
						<xsl:with-param name='tel' select='text()' />
					</xsl:call-template>
				</xsl:element>
			</xsl:for-each>

		</xsl:element>

	</xsl:template>

	<xsl:template name='team'>
		<xsl:element name='h2'>
			Équipe
		</xsl:element>
		<xsl:element name='table'>

			<xsl:for-each select='stb:team/stb:person'>
				<xsl:element name='tr'>
					<xsl:element name='td'>
						<xsl:value-of select='stb:firstname/@gender'></xsl:value-of>
					</xsl:element>
					<xsl:element name='td'>
						<xsl:element name='b'>
							<xsl:value-of select='stb:firstname/@lastname' /> 
							<xsl:text> </xsl:text>
							<xsl:value-of select='stb:firstname' />
						</xsl:element>
					</xsl:element>
					<xsl:element name='td'>
						<xsl:attribute name='class'>role</xsl:attribute>
						<xsl:apply-templates select="stb:function"/>
					</xsl:element>
				</xsl:element>
				<xsl:element name='tr'>
					<xsl:element name='td'>
						<xsl:value-of select='stb:firstname/@mail' />
					</xsl:element>
				</xsl:element>


			</xsl:for-each>

		</xsl:element>

	</xsl:template>
	
	<xsl:template match="stb:function">
    	<xsl:if test="position() >1"> | </xsl:if>
   		<xsl:value-of select="." />
   	</xsl:template>

	<xsl:template name='detail'>
		<xsl:element name='h2'>
			Liste des fonctionnalités
		</xsl:element>

		<xsl:for-each select='stb:detail/stb:feature'>
			<xsl:element name='div'>

				<xsl:if test='position() mod 2=0'>
					<xsl:attribute name='class'>gris</xsl:attribute>
				</xsl:if>


				<xsl:element name='p'>
					Item
					<xsl:value-of select='@number' />
					.
					<xsl:value-of select='@section' />

				</xsl:element>


				<xsl:element name='p'>
					<xsl:text>Priorité: </xsl:text>
					<xsl:value-of select='stb:priority'></xsl:value-of>
				</xsl:element>
				<xsl:element name='p'>
					<xsl:text>Livraison </xsl:text>
					<xsl:call-template name='dateformat'>
						<xsl:with-param name='date' select='stb:delivery' />
					</xsl:call-template>
				</xsl:element>
				<xsl:element name='p'>
					<xsl:value-of select='stb:description'></xsl:value-of>
				</xsl:element>
			</xsl:element>
			<xsl:element name='br' />
		</xsl:for-each>


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

	<xsl:template name='telephoneFormat'>
		<xsl:param name='tel' />

		<xsl:choose>
			<xsl:when test="starts-with($tel,'+')">
				+33 (0)
				<xsl:value-of select="substring-after($tel,'+33 ') " />
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select='$tel ' />
			</xsl:otherwise>
		</xsl:choose>

	</xsl:template>
</xsl:stylesheet>