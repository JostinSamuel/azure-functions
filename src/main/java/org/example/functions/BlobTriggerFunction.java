package org.example.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class BlobTriggerFunction {
    /**
     * This function will be invoked when a new or updated blob is detected at the specified path. The blob contents are provided as input to this function.
     */
    @FunctionName("BlobTriggerFunction")
    @StorageAccount("AzureWebJobsStorage")
    public void run(
        @BlobTrigger(name = "content", path = "mycontainer/{name}", dataType = "binary") byte[] content,
        @BindingName("name") String name,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + name + "\n  Size: " + content.length + " Bytes");
    }
}
