package com.example.demo.valition;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.example.demo.valition.Groups.First;
import com.example.demo.valition.Groups.Second;
import com.example.demo.valition.Groups.Third;

@GroupSequence({Default.class,First.class,Second.class,Third.class})
public interface Groups {
    public interface First{}
    public interface Second{}
    public interface Third{}
}