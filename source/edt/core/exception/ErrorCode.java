package edt.core.exception;

/** Error codes for the exceptions handling */
public final class ErrorCode {

    /** Document not found */
    public static final String DOCUMENT_NOT_FOUND = "DOCUMENT_NOT_FOUND_EXCEPTION";

    /** Error serializing document */
    public static final String DOCUMENT_SERIALIZE_ERROR = "DOCUMENT_SERIALIZE_EXCEPTION";

    /** Error deserializing document. */
    public static final String DOCUMENT_DESERIALIZE_ERROR = "DOCUMENT_DESERIALIZE_EXCEPTION";

    /** Error closing file. */
    public static final String FILE_CLOSE_ERROR = "FILE_CLOSE_EXCEPTION";

    /** Section not found */
    public static final String SECTION_NOT_FOUND = "SECTION_NOT_FOUND_EXCEPTION";

    /** Paragraph not found */
    public static final String PARAGRAPH_NOT_FOUND = "PARAGRAPH_NOT_FOUND_EXCEPTION";    
}