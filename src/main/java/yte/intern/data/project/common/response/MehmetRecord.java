package yte.intern.data.project.common.response;

public record MehmetRecord(
        ResponseType responseType,
        String message,
        String isAuthority
) {
}
