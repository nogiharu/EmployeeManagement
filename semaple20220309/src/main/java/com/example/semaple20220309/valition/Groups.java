package com.example.semaple20220309.valition;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.example.semaple20220309.valition.Groups.First;
import com.example.semaple20220309.valition.Groups.Second;
import com.example.semaple20220309.valition.Groups.Third;

@GroupSequence({Default.class,First.class,Second.class,Third.class})
public interface Groups {
    public interface First{}
    public interface Second{}
    public interface Third{}
}