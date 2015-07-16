/*******************************************************************************
 * Copyright (c) 2015 Thales Global Services SAS                                *
 * Author : Aravindan Mahendran                                                 *
 *                                                                              *
 * The MIT license.                                                             *
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

package com.thalesgroup.dtkit.tusar;

import org.jenkinsci.lib.dtkit.model.InputMetricXSL;
import org.jenkinsci.lib.dtkit.model.InputType;
import org.jenkinsci.lib.dtkit.model.OutputMetric;
import com.thalesgroup.dtkit.processor.InputMetric;
import com.thalesgroup.dtkit.tusar.model.TusarModel;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "conqatduplications", namespace = "tusar")
@InputMetric
public class ConQATDuplications extends InputMetricXSL {

    @Override
    public InputType getToolType() {
        return InputType.MEASURE;
    }

    @Override
    public String getToolName() {
        return "ConQATDuplications";
    }

    @Override
    public String getToolVersion() {
        return "2014.1";
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public String getXslName() {
        return "ConQat-2014.1-to-tusar-8-dup.xsl";
    }

    @Override
    public String[] getInputXsdNameList() {
        return null;
    }

    @Override
    public OutputMetric getOutputFormatType() {
        return TusarModel.OUTPUT_TUSAR_8_0;
    }
}