package co.com.ikitech.model.guardianship.error;

public enum GuardianMessageError {
    GUARDIAN_Not_Exist("guardian.guardianNoExist"),

    GUARDIAN_Not_Create("guardian.guardianNotCreate"),

    SPRINT_HAS_ALREADY_GUARDIAN("guardian.sprintHasGuardian");

    public final String value;

    GuardianMessageError(String value){ this.value = value;}
}
