package com.dtone.dvs.serdes;

import java.io.IOException;

import com.dtone.dvs.dto.AmountValue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom Serializer for {@link AmountValue}.
 */
public class AmountValueSer extends JsonSerializer<AmountValue> {

  /**
   * {@inheritDoc}
   */
  @Override
  public void serialize(AmountValue value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    if (value.getValue() != null) {
      gen.writeNumber(value.getValue());
    } else {
      gen.writeStartObject();
      gen.writeNumberField("min", value.getMin());
      gen.writeNumberField("max", value.getMax());
      gen.writeEndObject();
    }
  }
}
