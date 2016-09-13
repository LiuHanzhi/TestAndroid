package com.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class OpstringsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void testB() {
        System.out.println("Fixed Tests rot90Clock");
        testing(Opstrings.rot90Clock("rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb"),
                "Sixdvr\ndJNCGg\nmBWhca\nEYgZEv\nKDXVKc\nbORWle");

        System.out.println("Fixed Tests diag1Sym");
        testing(Opstrings.diag1Sym("wuUyPC\neNHWxw\nehifmi\ntBTlFI\nvWNpdv\nIFkGjZ"),
                "weetvI\nuNhBWF\nUHiTNk\nyWflpG\nPxmFdj\nCwiIvZ");

        System.out.println("Fixed Tests selfieAndDiag1");
        testing(Opstrings.selfieAndDiag1("NJVGhr\nMObsvw\ntPhCtl\nsoEnhi\nrtQRLK\nzjliWg"),
                "NJVGhr|NMtsrz\nMObsvw|JOPotj\ntPhCtl|VbhEQl\nsoEnhi|GsCnRi\nrtQRLK|hvthLW\nzjliWg|rwliKg");
    }
}

