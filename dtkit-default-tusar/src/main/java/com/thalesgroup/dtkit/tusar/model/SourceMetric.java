/**
 * Maven and Sonar plugin for .Net
 * Copyright (C) 2010 Jose Chillan and Alexandre Victoor
 * mailto: jose.chillan@codehaus.org or alexvictoor@codehaus.org
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

/*
 * Created on May 19, 2009
 */
package com.thalesgroup.dtkit.tusar.model;


/**
 * A base clase for the definition source metrics.
 *
 * @author Mohamed Koundoussi
 */
public class SourceMetric {

    // protected int countLines;
    protected int countBlankLines;
    /* protected int countStatements;
     protected int commentLines;
     protected int documentationLines;
     protected int countClasses;
     protected int countMethods;
     protected int countCalls;
     protected int countMethodStatements;
     */
    protected int complexity;
    protected int countAccessors;
 /* protected int number_of_files;
  protected double fileAverageComplexity;
  protected int fileMaxComplexity;
  */


    /**
     * Returns the countBlankLines.
     *
     * @return The countBlankLines to return.
     */
    public int getCountBlankLines() {
        return this.countBlankLines;
    }

    /**
     * Returns the complexity.
     *
     * @return The complexity to return.
     */
    public int getComplexity() {
        return this.complexity;
    }


    /**
     * Returns the countAccessors.
     *
     * @return The countAccessors to return.
     */
    public int getCountAccessors() {
        return this.countAccessors;
    }

    /**
     * Sets the countAccessors.
     *
     * @param countAccessors The countAccessors to set.
     */
    public void setCountAccessors(int countAccessors) {
        this.countAccessors = countAccessors;
    }
}
