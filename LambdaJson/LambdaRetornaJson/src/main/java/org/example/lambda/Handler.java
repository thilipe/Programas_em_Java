package org.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Input, Output> {

    @Override
    public Output handleRequest(Input input, Context context) {

        String name = input.getName();

        // Log (aparece no CloudWatch)
        context.getLogger().log("Received: " + name);

        return new Output("Olá " + name + "!" + " feito com o lambda da AWS");
    }
}

