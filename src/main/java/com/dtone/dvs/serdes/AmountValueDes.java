package com.dtone.dvs.serdes;

import java.io.IOException;

import com.dtone.dvs.dto.AmountValue;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * Custom deserializer for {@link AmountValue}.
 */
public class AmountValueDes extends JsonDeserializer<AmountValue> {

  /**
   * {@inheritDoc}
   */
  @Override
  public AmountValue deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
    var value = new AmountValue();

    if (jp.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
      value.setValue((jp.getDecimalValue()));
    } else {
      var node = jp.getCodec().readTree(jp);
      value.setMin(((IntNode)node.get("min")).decimalValue());
      value.setMax(((IntNode) node.get("max")).decimalValue());
    }

    return value;
  }
}
