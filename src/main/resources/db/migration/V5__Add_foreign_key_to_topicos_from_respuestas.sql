ALTER TABLE topicos
ADD COLUMN respuesta_id BIGINT;

ALTER TABLE topicos
ADD CONSTRAINT fk_topicos_respuestas
FOREIGN KEY (respuesta_id)
REFERENCES respuestas(id);
