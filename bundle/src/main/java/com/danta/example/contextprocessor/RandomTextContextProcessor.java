package com.danta.example.contextprocessor;

import com.google.common.collect.Sets;
import danta.api.ContentModel;
import danta.api.ExecutionContext;
import danta.api.exceptions.ProcessException;
import danta.core.contextprocessors.AbstractCheckComponentCategoryContextProcessor;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Set;

import static danta.Constants.CONTENT;
import static danta.Constants.DOT;

@Component
@Service
public class RandomTextContextProcessor extends AbstractCheckComponentCategoryContextProcessor {

    private static final String RANDOM_TEXT_CATEGORY = "randomText";
    private static final String RANDOM_TEXT_KEY = CONTENT + DOT + RANDOM_TEXT_CATEGORY;

    private static final Set<String> ANY_OF = Collections.unmodifiableSet(Sets.newHashSet(RANDOM_TEXT_CATEGORY));

    @Override
    public Set<String> anyOf() {
        return ANY_OF;
    }

    @Override
    public void process(ExecutionContext executionContext, ContentModel contentModel) throws ProcessException {
        // contentModel.set(RANDOM_TEXT_KEY, randomString() + randomString() + randomString());
    }

    private String randomString() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
}