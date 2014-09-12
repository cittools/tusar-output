<?xml version="1.0" encoding="UTF-8"?>
<!--
/*******************************************************************************
* Copyright (c) 2010 Thales Corporate Services SAS                             *
* Author : Gregory Boissinot, Joel Forner                                      *
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
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:t="http://www.thalesgroup.com/tusar/tests/v3"
                version="2.0"
        >
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

    <xsl:template match="testsuites">

        <tusar:tusar
                xmlns:t="http://www.thalesgroup.com/tusar/tests/v3"
                xmlns:tusar="http://www.thalesgroup.com/tusar/v3"
                version="3.0">

            <xsl:element name="tusar:tests">
                <xsl:attribute name="toolname">phpunit</xsl:attribute>
                <xsl:apply-templates select="testsuite"/>
            </xsl:element>

        </tusar:tusar>

    </xsl:template>

    <xsl:template match="testsuite">

        <xsl:if test="testcase">

            <xsl:element name="t:testsuite">

                <xsl:attribute name="name">
                    <xsl:value-of select="@name"/>
                </xsl:attribute>

                <xsl:attribute name="tests">
                    <xsl:value-of select="@tests"/>
                </xsl:attribute>

                <xsl:attribute name="failures">
                    <xsl:value-of select="@failures"/>
                </xsl:attribute>

                <xsl:attribute name="errors">
                    <xsl:value-of select="@errors"/>
                </xsl:attribute>

                <xsl:attribute name="skipped">
                    <xsl:value-of select="@skipped"/>
                </xsl:attribute>

                <xsl:attribute name="time">
                    <xsl:value-of select="@time"/>
                </xsl:attribute>

                <xsl:attribute name="timestamp">
                    <xsl:value-of select="@timestamp"/>
                </xsl:attribute>

                <xsl:if test="properties">
                    <xsl:element name="t:properties">
                        <xsl:for-each select="properties/property">
                            <xsl:element name="t:property">

                                <xsl:attribute name="name">
                                    <xsl:value-of select="@name"/>
                                </xsl:attribute>

                                <xsl:attribute name="value">
                                    <xsl:value-of select="@value"/>
                                </xsl:attribute>

                            </xsl:element>
                        </xsl:for-each>
                    </xsl:element>
                </xsl:if>

                <xsl:for-each select="testcase">
                    <xsl:element name="t:testcase">

                        <xsl:if test="@class != ''">
                            <xsl:attribute name="fulltestname">
                                <xsl:value-of select="@class"/>
                            </xsl:attribute>
                        </xsl:if>

                        <xsl:attribute name="testname">
                            <xsl:value-of select="@name"/>
                        </xsl:attribute>

                        <xsl:attribute name="time">
                            <xsl:value-of select="@time"/>
                        </xsl:attribute>

                        <xsl:attribute name="assertions">
                            <xsl:value-of select="@assertions"/>
                        </xsl:attribute>

                        <xsl:if test="error">
                            <xsl:element name="t:error">
                                <xsl:attribute name="message">
                                    <xsl:value-of select="error/@message"/>
                                </xsl:attribute>

                                <xsl:attribute name="type">
                                    <xsl:value-of select="error/@type"/>
                                </xsl:attribute>

                                <xsl:value-of select="error"/>
                            </xsl:element>
                        </xsl:if>

                        <xsl:if test="failure">
                            <xsl:element name="t:failure">
                                <xsl:attribute name="message">
                                    <xsl:value-of select="failure/@message"/>
                                </xsl:attribute>

                                <xsl:attribute name="type">
                                    <xsl:value-of select="failure/@type"/>
                                </xsl:attribute>

                                <xsl:value-of select="failure"/>
                            </xsl:element>
                        </xsl:if>

                        <xsl:if test="system-out">
                            <xsl:element name="t:system-out">
                                <xsl:value-of select="system-out"/>
                            </xsl:element>
                        </xsl:if>

                        <xsl:if test="system-err">
                            <xsl:element name="t:system-err">
                                <xsl:value-of select="system-err"/>
                            </xsl:element>
                        </xsl:if>

                    </xsl:element>
                </xsl:for-each>

                <xsl:if test="system-out">
                    <xsl:element name="t:system-out">
                        <xsl:value-of select="system-out"/>
                    </xsl:element>
                </xsl:if>

                <xsl:if test="system-err">
                    <xsl:element name="t:system-err">
                        <xsl:value-of select="system-err"/>
                    </xsl:element>
                </xsl:if>

            </xsl:element>

        </xsl:if>

        <xsl:apply-templates select="testsuite"/>


    </xsl:template>

    <xsl:template match="text()|@*"/>
</xsl:stylesheet>