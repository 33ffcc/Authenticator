package com.android.authenticator.otp;

import static org.junit.Assert.assertEquals;

import com.android.authenticator.crypto.otp.MOTPTest;
import com.android.authenticator.encoding.EncodingException;
import com.android.authenticator.encoding.Hex;

import org.junit.Test;

public class MotpInfoTest {
    @Test
    public void testMotpInfoOtp() throws OtpInfoException, EncodingException {
        for (MOTPTest.Vector vector : MOTPTest.VECTORS) {
            MotpInfo info = new MotpInfo(Hex.decode(vector.Secret), vector.Pin);
            assertEquals(vector.OTP, info.getOtp(vector.Time));
        }
    }
}
