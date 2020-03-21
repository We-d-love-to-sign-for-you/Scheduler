package org.wedlovetosignforyou;

import java.util.List;

public interface InterpreterRepository {

    List<Interpreter> findAvailableInterpretersBySkillNameAndMinLevel(String skillName, String minSkillLevel);

    void saveInterpreter(Interpreter interpreter);

}
