<?xml version="1.0" encoding="UTF-8"?>
<!--
/*******************************************************************************
* Copyright (c) 2012 Thales Corporate Services SAS                             *
* Author : Herve Debu, Aravindan Mahendran, Fabrice Fauvel                     *
*                                                                              *
* Permission is hereby granted, free of charge, to any person obtaining a copy *
* of this software and associated documentation files (the "Software"), to deal*
* in the Software without restriction, including without limitation the rights *
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell    *
* copies of the Software, and to permit persons to whom the Software is        *
* furnished to do so, subject to the following conditions:                     *
*                                                                              *
* The above copyright notice and this permission notice shall be included in   *
* all copies or substantial portions of the Software.                          *
*                                                                              *
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR   *
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,     *
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  *
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER       *
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,*
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN    *
* THE SOFTWARE.                                                                *
*******************************************************************************/
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:m="http://www.thalesgroup.com/tusar/measures/v6"
                xmlns:d="http://www.thalesgroup.com/tusar/duplications/v1"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:ns="http://conqat.cs.tum.edu/ns/clonereport">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" cdata-section-elements="text"/>
    
    <xsl:variable name="root" select="'CloneAnalysis/'"/>
	
    <xsl:template match="/">
        <tusar:tusar
                xmlns:m="http://www.thalesgroup.com/tusar/measures/v6"
                xmlns:d="http://www.thalesgroup.com/tusar/duplications/v1"
                xmlns:tusar="http://www.thalesgroup.com/tusar/v8"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                version="8.0">

            <xsl:element name="tusar:measures">

                <xsl:attribute name="toolname">ConQat</xsl:attribute>
                <xsl:attribute name="version">2014.1</xsl:attribute>
                
                <xsl:element name="m:duplications">
					<xsl:for-each select="//ns:cloneClass">
						<xsl:element name="d:set">
							<xsl:for-each select="./ns:clone">
								<xsl:choose>
									<xsl:when test="@id = ../@id+1">
										<xsl:attribute name="lines">
                                            <xsl:if test="@endLine">
                                                <xsl:value-of select="@endLine - @startLine"/>
                                            </xsl:if>
                                            <xsl:if test="@lineCount">
                                                <xsl:value-of select="@lineCount"/>
                                            </xsl:if>
										</xsl:attribute>
									</xsl:when>
								</xsl:choose>
							</xsl:for-each>
							<xsl:attribute name="tokens">
								<xsl:value-of select="0"/>
							</xsl:attribute>
							<xsl:for-each select="./ns:clone">
								<xsl:variable name="sourceFileId" select="@sourceFileId"/>
								<xsl:element name="d:resource">
									<xsl:for-each select="//ns:sourceFile">
										<xsl:choose>
											<xsl:when test="@id = $sourceFileId">
                                                <xsl:variable name="path" select="substring-after(@path,$root)"/>
												<xsl:attribute name="path">
                                                    <!-- Check that path variable is not empty -->
                                                    <xsl:if test="not($path)">
                                                        <xsl:value-of select="@path"/>
                                                    </xsl:if>
                                                    <xsl:if test="$path">
                                                        <xsl:value-of select="$path"/>
                                                    </xsl:if>
												</xsl:attribute>												
											</xsl:when>
										</xsl:choose>
									</xsl:for-each>
									<xsl:attribute name="line">
										<xsl:value-of select="@startLine"/>
									</xsl:attribute>
								</xsl:element>
							</xsl:for-each>
						</xsl:element>
					</xsl:for-each>
				
				</xsl:element>
            </xsl:element>
        </tusar:tusar>
    </xsl:template>
</xsl:stylesheet>