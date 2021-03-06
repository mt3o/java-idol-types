/*
 * Copyright 2016 Hewlett Packard Enterprise Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.types.idol.marshalling.processors;

import com.autonomy.aci.client.transport.AciResponseInputStream;
import com.hp.autonomy.types.idol.marshalling.marshallers.ResponseDataParser;
import com.hp.autonomy.types.idol.responses.GetStatusResponseData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.portable.InputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ResponseDataProcessorTest {
    @Mock
    private ResponseDataParser<GetStatusResponseData> responseDataParser;

    @Mock
    private AciResponseInputStream inputStream;

    private ResponseDataProcessor<GetStatusResponseData> aciResponseProcessor;

    @Before
    public void setUp() {
        aciResponseProcessor = new ResponseDataProcessor<>(responseDataParser);
    }

    @Test
    public void process() {
        aciResponseProcessor.process(inputStream);
        verify(responseDataParser).parseResponseData(any(InputStream.class));
    }
}
