package co.com.ikitech.model.guardianship.error;

public enum AttachmentMessageError {

    ATTACHMENT_Not_Exist("attachment.attachmentNoExist"),

    ATTACHMENT_Not_Create("attachment.attachmentNotCreate"),

    SPRINT_HAS_ALREADY_ATTACHMENT("attachment.sprintHasAttachment");

    public final String value;

    AttachmentMessageError(String value){ this.value = value;}
}
