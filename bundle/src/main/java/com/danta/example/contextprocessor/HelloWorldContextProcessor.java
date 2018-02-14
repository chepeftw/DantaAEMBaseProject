package com.danta.example.contextprocessor;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import danta.api.ContentModel;
import danta.api.ExecutionContext;
import danta.aem.contextprocessors.AbstractResourceTypeCheckContextProcessor;

import static danta.Constants.CONTENT;
import static danta.Constants.DOT;
import static danta.Constants.LOW_PRIORITY;

@Component
@Service
public class HelloWorldContextProcessor extends AbstractResourceTypeCheckContextProcessor<ContentModel> {

    private static final String TITLE_PROPERTY_KEY = CONTENT + DOT + "title";

    @Override
    public String requiredResourceType() {
        return "danta-example/components/section/hellox";
    }

    @Override
    public void process(final ExecutionContext executionContext, final ContentModel contentModel) {
        if (contentModel.has(TITLE_PROPERTY_KEY)) {
            String titleProp = contentModel.getAsString(TITLE_PROPERTY_KEY);
            titleProp = "World! ... " + titleProp;
            contentModel.set(TITLE_PROPERTY_KEY, titleProp);
        }
    }

    @Override
    public boolean mustExist(){
        return false;
    }

    @Override
    public int priority() { return LOW_PRIORITY; }
}