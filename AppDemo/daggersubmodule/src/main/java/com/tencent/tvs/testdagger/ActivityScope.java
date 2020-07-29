package com.tencent.tvs.testdagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by johnny on 2017/6/8.
 */
@Documented
@Retention(RUNTIME)
@Scope
public @interface ActivityScope {}
