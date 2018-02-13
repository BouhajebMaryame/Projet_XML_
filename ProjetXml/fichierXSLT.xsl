<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <xsl:output 
        method="html"
        encoding="UTF-8"
        doctype-public="-//W3C//DTD HTML 4.01//EN"
        doctype-system="http://www.w3.org/TR/html4/strict.dtd"
        indent="yes" />
    
    <xsl:template match="/">
        <html>
            <head>
                <title> Transformation XSLT </title>
            </head>
            <body>
                <svg width="1000" height="880" xmlns="http://www.w3.org/2000/svg" xmlns:link="http://www.w3.org/1999/xlink">
                    <g stroke-width="3" fill="white" stroke="black" fill-opacity="0">
                        <xsl:for-each select="/scene/figures"> 
                            
                                <xsl:if test="cercle">
                                    <circle cx="{cercle/point/@x}" cy="{cercle/point/@y}" r="{cercle/@rayon}"/>
                                </xsl:if>
                                <xsl:if test="rectangle">
                                    <rect x="{rectangle/point/@x}" y="{rectangle/point/@y}" width="{rectangle/@largeur}" height="{rectangle/@longeur}"/>
                                </xsl:if>
                                <xsl:if test="carre">
                                    <rect x="{carre/point/@x}" y="{carre/point/@y}" width="{carre/@arc}" height="{carre/@arc}"/>
                                </xsl:if>
                                <xsl:if test="triangle">
                                    <xsl:call-template name="paramTriangle">
                                        <xsl:with-param name="paramT" select="triangle"/>
                                    </xsl:call-template>
                                </xsl:if>
                                <xsl:if test="Droit">
                                    <xsl:call-template name="paramDroit">
                                        <xsl:with-param name="paramD" select="Droit"/>
                                    </xsl:call-template>
                                </xsl:if>
                            
                        </xsl:for-each>
                    </g>
                </svg>
                <xsl:for-each select="/scene/rules/rule">  
                    <xsl:if test="type">
                        <p> <xsl:value-of select="type"/> </p>  
                    </xsl:if>
                    <xsl:if test="description">  
                        <p> <xsl:value-of select="description"/> </p>
                    </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
    <xsl:template name="paramDroit">
        <xsl:param name="paramD"/>
        <xsl:for-each select="$paramD">
            <line xmlns="http://www.w3.org/2000/svg" x1="{point[1]/@x}" y1="{point[1]/@y}" x2="{point[2]/@x}" y2="{point[2]/@y}" />
        </xsl:for-each>
    </xsl:template>
    <xsl:template name="paramTriangle">
        <xsl:param name="paramT"/>
        <xsl:for-each select="$paramT">
            <polygon xmlns="http://www.w3.org/2000/svg" points=" {point[1]/@x} {point[1]/@y}, {point[2]/@x} {point[2]/@y}, {point[3]/@x} {point[3]/@y}"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>