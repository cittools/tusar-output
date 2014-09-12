package com.thalesgroup.dtkit.tusar;


import org.jenkinsci.lib.dtkit.model.InputMetricOther;
import org.jenkinsci.lib.dtkit.model.InputType;
import org.jenkinsci.lib.dtkit.model.OutputMetric;
import com.thalesgroup.dtkit.processor.InputMetric;
import com.thalesgroup.dtkit.tusar.model.TusarModel;
import org.jenkinsci.lib.dtkit.util.converter.ConversionException;
import org.jenkinsci.lib.dtkit.util.validator.ValidationException;

import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.util.Map;


@XmlType(name = "purify", namespace = "tusar")
@InputMetric
public class Purify extends InputMetricOther {

    @Override
    public InputType getToolType() {
        return InputType.MEASURE;
    }

    @Override
    public String getToolName() {
        return "Purify";
    }

    @Override
    public String getToolVersion() {
        return "7.0.0";
    }


    @Override
    public OutputMetric getOutputFormatType() {

        return TusarModel.OUTPUT_TUSAR_11_0;

    }

    @Override
    public boolean isDefault() {
        return true;
    }

    /**
     * Convert an input file to an output file
     * Give your conversion process
     * Input and Output files are relatives to the filesystem where the process is executed on (like Hudson agent)
     *
     * @param inputFile the input file to convert
     * @param outFile   the output file to convert
     * @param params    the xsl parameters
     * @throws org.jenkinsci.lib.dtkit.util.converter.ConversionException an application Exception to throw when there is an error of conversion
     *                                                                  The exception is catch by the API client (as Hudson plugin)
     */
    @Override
    public void convert(File inputFile, File outFile, Map<String, Object> params) throws ConversionException {
        PurifyReportParser parser = new PurifyReportParser();
        File inputFile2 = new File(inputFile.getAbsolutePath().replace(".txt", "_txt") + ".xml");
        PurifyTextParser.parse(inputFile.getAbsolutePath(), inputFile2.getAbsolutePath());
        parser.convert(inputFile2, outFile);
    }

    /*
     *  Gives the validation process for the input file
     *
     * @return true if the input file is valid, false otherwise
     */
    @Override
    public boolean validateInputFile(File inputXMLFile) throws ValidationException {
        return true;
    }

    /*
     *  Gives the validation process for the output file
     *
     * @return true if the input file is valid, false otherwise
     */
    @Override
    public boolean validateOutputFile(File inputXMLFile) throws ValidationException {
        return true;
    }

}



