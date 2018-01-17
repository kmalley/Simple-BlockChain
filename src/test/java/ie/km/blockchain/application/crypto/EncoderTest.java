package ie.km.blockchain.application.crypto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class EncoderTest {

    @Test
    public void encode() {
       assertThat(Encoder.encode("asdasdasd".getBytes())).isNotBlank();
    }

    @Test
    public void digest() {
        assertThat(Encoder.digest("dsfsdfsdf".getBytes())).isNotEmpty();
    }
}