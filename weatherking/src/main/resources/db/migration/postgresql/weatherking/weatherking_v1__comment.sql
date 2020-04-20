CREATE TABLE public.comment
(
    comment_id bigserial NOT NULL,
    message character varying,
    PRIMARY KEY (comment_id)
);

ALTER TABLE public.comment
    OWNER to postgres;