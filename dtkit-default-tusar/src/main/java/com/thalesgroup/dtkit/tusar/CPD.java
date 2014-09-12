package com.thalesgroup.dtkit.tusar;

import org.jenkinsci.lib.dtkit.model.InputMetricXSL;
import org.jenkinsci.lib.dtkit.model.InputType;
import org.jenkinsci.lib.dtkit.model.OutputMetric;
import com.thalesgroup.dtkit.processor.InputMetric;
import com.thalesgroup.dtkit.tusar.model.TusarModel;

import javax.xml.bind.annotation.XmlType;

/**
 * @author Gregory Boissinot
 */
@XmlType(name = "cpd", namespace = "tusar")
@InputMetric
public class CPD extends InputMetricXSL {

    @Override
    public InputType getToolType() {
        return InputType.MEASURE;
    }

    @Override
    public String getToolName() {
        return "CPD";
    }

    @Override
    public String getToolVersion() {
        return "4.2";
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public String getXslName() {
        return "cpd-4.2-to-tusar-8.0.xsl";
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