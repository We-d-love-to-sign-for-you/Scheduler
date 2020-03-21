package org.wedlovetosignforyou;

import java.util.List;

public interface InterpreterRepository {

    List<Interpreter> findInterpretersBySkillName(String skillName);

}
