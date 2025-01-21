CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(255) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    is_solucion BOOLEAN NOT NULL DEFAULT FALSE,
    usuario_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_respuestas_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_respuestas_topico FOREIGN KEY (topico_id) REFERENCES topicos(id)
);
