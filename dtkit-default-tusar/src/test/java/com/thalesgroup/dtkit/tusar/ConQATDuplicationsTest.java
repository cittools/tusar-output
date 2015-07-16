package com.thalesgroup.dtkit.tusar;

import org.junit.Test;

/**
 * @author Aravindan Mahendran
 */
public class ConQATDuplicationsTest extends AbstractTest {

    @Test
    public void testcase1() throws Exception {
        convertAndValidate(ConQATDuplications.class, "conqatduplications/testcase1/testresult.xml", "conqatduplications/testcase1/tusar-result.xml");
    }
    
    @Test
    public void testcase2() throws Exception {
        convertAndValidate(ConQATDuplications.class, "conqatduplications/testcase2/testresult.xml", "conqatduplications/testcase2/tusar-result.xml");
    }
}
