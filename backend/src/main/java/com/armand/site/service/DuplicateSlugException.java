package com.armand.site.service;

public class DuplicateSlugException extends RuntimeException
{
    public DuplicateSlugException(String slug)
    {
        super("Slug already exists: " + slug);
    }
}
