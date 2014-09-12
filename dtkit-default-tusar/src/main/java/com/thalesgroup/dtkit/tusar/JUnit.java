/*******************************************************************************
 * Copyright (c) 2010-2011 Thales Corporate Services SAS                        *
 * Author : Gregory Boissinot                                                   *
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
import org.jenkinsci.lib.dtkit.util.validator.ValidationError;
import org.jenkinsci.lib.dtkit.util.validator.ValidationException;

import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.util.List;


@XmlType(name = "junit", namespace = "tusar")
@InputMetric
public class JUnit extends InputMetricXSL {

    @Override
    public InputType getToolType() {
        return InputType.TEST;
    }

    @Override
    public String getToolName() {
        return "JUnit";
    }

    @Override
    public String getToolVersion() {
        return "3.0";
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public String getXslName() {
        return "junit-3-to-tusar-6.xsl";
    }
    
    @Override
    public String[] getInputXsdNameList() {
        return new String[]{"junit-3.xsd"};
    }

    @Override
    public OutputMetric getOutputFormatType() {
        return TusarModel.OUTPUT_TUSAR_6_0;
    }
    
}

