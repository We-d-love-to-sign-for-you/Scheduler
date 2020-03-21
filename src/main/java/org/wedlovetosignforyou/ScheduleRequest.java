package org.wedlovetosignforyou;

public class ScheduleRequest {
    private String skillName;
    private String minSkillLevel;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getMinSkillLevel() {
        return minSkillLevel;
    }

    public void setMinSkillLevel(String minSkillLevel) {
        this.minSkillLevel = minSkillLevel;
    }

    @Override
    public String toString() {
        return "ScheduleRequest{" +
                "skillName='" + skillName + '\'' +
                ", minSkillLevel='" + minSkillLevel + '\'' +
                '}';
    }
}
