package main.infrastructure.security;

import main.human_resources.IPerson;
import main.human_resources.Person;

import java.util.Date;
import java.util.List;

public interface IROIDCard {
    public String getId();
    boolean getIsLocked();
}
