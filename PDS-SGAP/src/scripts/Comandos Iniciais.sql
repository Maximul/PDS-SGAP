DROP DATABASE IF EXISTS BD_PDS_SGAP;
CREATE DATABASE BD_PDS_SGAP;
USE BD_PDS_SGAP;

DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_PRODUTO(P_PRODUTO INT)
BEGIN
    SELECT DISTINCT *
    FROM SOLICITACAOALUGUEL 
    WHERE DATAINICIOALUGUEL > CURRENT_DATE
    AND PRODUTO_CODIGO IN (SELECT CODIGO 
                           FROM PRODUTO 
                           WHERE CODIGO = P_PRODUTO);
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_SOLICITADOS(P_DONO INT, P_PRODUTO VARCHAR(255))
BEGIN
    DECLARE V_EXISTE_ALUGUEL BOOLEAN DEFAULT 0;
    DECLARE V_EXISTE_SOLICITACAO BOOLEAN DEFAULT 0;
    DECLARE V_PRODUTO_ALUGANDO BOOLEAN DEFAULT 0;
    DECLARE V_SOLICITACAO_VALIDA BOOLEAN DEFAULT 0;
    DECLARE V_TAMANHO_PRODUTOS INT DEFAULT 0;
    DECLARE V_CONTADOR INT DEFAULT 1;
    DECLARE V_PRODUTO_ATUAL INT DEFAULT 0;
    DECLARE V_ALUGUEL INT DEFAULT 0;
    DECLARE V_CONSULTA_COMPLETA VARCHAR(10000) DEFAULT '';
    
    SET V_TAMANHO_PRODUTOS = (SELECT COUNT(*) 
                              FROM PRODUTO 
                              WHERE CONDOMINO_CODIGO = P_DONO 
                              AND NOME LIKE P_PRODUTO);
    
    IF V_TAMANHO_PRODUTOS > 0 THEN
        WHILE V_CONTADOR <= V_TAMANHO_PRODUTOS DO
            SET V_PRODUTO_ATUAL = (SELECT MAX(CODIGO_ATUAL) 
                                   FROM (SELECT CODIGO AS CODIGO_ATUAL 
                                         FROM PRODUTO 
                                         WHERE CONDOMINO_CODIGO = P_DONO 
                                         AND NOME LIKE P_PRODUTO 
                                         ORDER BY CODIGO_ATUAL 
                                         LIMIT V_CONTADOR) AS PEGAR_PRODUTO_ATUAL);

            SET V_EXISTE_SOLICITACAO = (SELECT COUNT(*) 
                                        FROM SOLICITACAOALUGUEL 
                                        WHERE PRODUTO_CODIGO = V_PRODUTO_ATUAL);
			
            IF V_EXISTE_SOLICITACAO THEN
                SET V_EXISTE_ALUGUEL = (SELECT COUNT(*) 
                                        FROM ALUGUEL 
                                        WHERE SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO 
                                                                            FROM SOLICITACAOALUGUEL 
                                                                            WHERE PRODUTO_CODIGO = V_PRODUTO_ATUAL));

                IF V_EXISTE_ALUGUEL THEN
                    SET V_ALUGUEL = (SELECT MAX(CODIGO) 
                                     FROM ALUGUEL 
                                     WHERE SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO
                                                                         FROM SOLICITACAOALUGUEL
                                                                         WHERE PRODUTO_CODIGO = V_PRODUTO_ATUAL));

                    SET V_PRODUTO_ALUGANDO = (SELECT COUNT(*) 
                                              FROM ALUGUEL 
                                              WHERE CODIGO = V_ALUGUEL 
                                              AND DATADEVOLUCAO IS NULL);

                    IF (V_CONTADOR = V_TAMANHO_PRODUTOS) THEN
                        IF NOT V_PRODUTO_ALUGANDO THEN
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = ', V_PRODUTO_ATUAL,' AND CODIGO NOT IN (SELECT PRODUTO_CODIGO FROM SOLICITACAOALUGUEL WHERE CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO FROM ALUGUEL WHERE CODIGO = ', V_ALUGUEL,' AND DATADEVOLUCAO IS NULL)))');
                        ELSE
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) ');
                        END IF;
                    ELSE
                        IF NOT V_PRODUTO_ALUGANDO THEN
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = ', V_PRODUTO_ATUAL,' AND CODIGO NOT IN (SELECT PRODUTO_CODIGO FROM SOLICITACAOALUGUEL WHERE CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO FROM ALUGUEL WHERE CODIGO = ', V_ALUGUEL,' AND DATADEVOLUCAO IS NULL))) UNION ');
                        ELSE
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) UNION ');
                        END IF;
                    END IF;
                ELSE
                    SET V_SOLICITACAO_VALIDA = (SELECT COUNT(*) 
                                                FROM SOLICITACAOALUGUEL 
                                                WHERE DATAINICIOALUGUEL > CURRENT_DATE 
                                                AND PRODUTO_CODIGO = V_PRODUTO_ATUAL);
			
                    IF V_SOLICITACAO_VALIDA THEN
                        IF (V_CONTADOR = V_TAMANHO_PRODUTOS) THEN
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = ', V_PRODUTO_ATUAL, ') ');
                        ELSE
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = ', V_PRODUTO_ATUAL, ') UNION ');
                        END IF;
                    ELSE
                        IF (V_CONTADOR = V_TAMANHO_PRODUTOS) THEN
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) ');
                        ELSE
                            SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) UNION ');
                        END IF;
                    END IF;
                END IF;
            ELSE
                IF (V_CONTADOR = V_TAMANHO_PRODUTOS) THEN
                    SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) ');
                ELSE
                    SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0) UNION');
                END IF;
            END IF;
			
            SET V_CONTADOR = V_CONTADOR + 1;
            SET V_PRODUTO_ATUAL = 0;
            SET V_ALUGUEL = 0;
        END WHILE;
    ELSE
        SET V_CONSULTA_COMPLETA = CONCAT(V_CONSULTA_COMPLETA, '(SELECT * FROM PRODUTO WHERE CODIGO = 0)');
    END IF;
    SELECT V_CONSULTA_COMPLETA AS RESULTADO;
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_PRODUTO_LOCATARIO(P_PRODUTO INT, P_LOCATARIO INT)
BEGIN
    SELECT DISTINCT *
    FROM SOLICITACAOALUGUEL 
    WHERE  PRODUTO_CODIGO IN (SELECT CODIGO 
                              FROM PRODUTO 
                              WHERE CODIGO = P_PRODUTO)
                              AND LOCATARIO_CODIGO IN (SELECT CODIGO
                                                       FROM CONDOMINO
                                                       WHERE CODIGO = P_LOCATARIO);
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_SOLICITADOS_LOCATARIO(P_LOCATARIO INT, P_PRODUTO VARCHAR(255))
BEGIN    
    SELECT DISTINCT *
    FROM PRODUTO AS P
    WHERE P.NOME LIKE P_PRODUTO
    AND P.CODIGO IN (SELECT PRODUTO_CODIGO 
                     FROM SOLICITACAOALUGUEL
                     WHERE LOCATARIO_CODIGO = P_LOCATARIO );
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_DISPONIVEIS( P_PRODUTO VARCHAR(255))
BEGIN	
    SELECT CODIGO
    FROM PRODUTO 
    WHERE CODIGO NOT IN (SELECT PRODUTO_CODIGO
                         FROM SOLICITACAOALUGUEL
                         WHERE CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO
                                          FROM ALUGUEL
                                          WHERE ALUGUEL.DATADEVOLUCAO IS  NULL))
    AND NOME LIKE P_PRODUTO;
END#
DELIMITER ;



DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_SOLICITADOS_EM_ANDAMENTO(P_LOCATARIO INT, P_PRODUTO VARCHAR(255), P_DATA DATE)
BEGIN
    DECLARE V_EXISTE_ALUGUEL BOOLEAN DEFAULT 0;
    DECLARE V_DATADEVOLUCAO_IS_NULL BOOLEAN DEFAULT 0;
	
    SET V_EXISTE_ALUGUEL = (SELECT COUNT(*) 
                            FROM ALUGUEL 
                            WHERE SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO 
                                                                FROM SOLICITACAOALUGUEL 
                                                                WHERE LOCATARIO_CODIGO = P_LOCATARIO));

    IF V_EXISTE_ALUGUEL THEN
        SET V_DATADEVOLUCAO_IS_NULL = (SELECT COUNT(*) 
                                       FROM ALUGUEL 
                                       WHERE DATADEVOLUCAO IS NULL
                                       AND SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO 
                                                                         FROM SOLICITACAOALUGUEL AS S
                                                                         WHERE S.locatario_codigo = P_LOCATARIO));
    END IF;
    
    IF V_EXISTE_ALUGUEL THEN
	IF NOT V_DATADEVOLUCAO_IS_NULL THEN
            SELECT DISTINCT * 
            FROM PRODUTO AS P
            WHERE  P.NOME LIKE P_PRODUTO
            AND P.CODIGO IN (SELECT PRODUTO_CODIGO 
                             FROM SOLICITACAOALUGUEL AS S
                             WHERE S.DATAINICIOALUGUEL >= P_DATA 
                             AND S.CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO 
                                              FROM ALUGUEL AS A
                                              WHERE S.CODIGO = A.SOLICITACAOALUGUEL_CODIGO
                                              AND A.DATADEVOLUCAO IS NOT NULL
                                              GROUP BY A.SOLICITACAOALUGUEL_CODIGO
                                              HAVING MAX(A.DATADEVOLUCAO) < P_DATA)
                            AND S.LOCATARIO_CODIGO = P_LOCATARIO);
        END IF;
    
     ELSE
        SELECT DISTINCT * 
        FROM PRODUTO
        WHERE  NOME LIKE P_PRODUTO
        AND CODIGO IN (SELECT PRODUTO_CODIGO 
                       FROM SOLICITACAOALUGUEL 
                       WHERE DATAINICIOALUGUEL >= P_DATA
                        AND LOCATARIO_CODIGO = P_LOCATARIO);
    END IF;
END#
DELIMITER ;

DELIMITER #
	CREATE FUNCTION F_DEVOLVE_DATA(P_DATADEVOLUCAO DATE) RETURNS DATE
BEGIN
	IF P_DATADEVOLUCAO IS NULL THEN
		RETURN CURRENT_DATE;
	ELSE
		RETURN P_DATADEVOLUCAO;
	END IF;
END#
DELIMITER ;


DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_CONFIRMACAO(P_LOCATARIO INT, P_PRODUTO VARCHAR(255))
BEGIN    

    SELECT * FROM SOLICITACAOALUGUEL
    WHERE LOCATARIO_CODIGO = P_LOCATARIO
    AND PRODUTO_CODIGO IN (SELECT CODIGO FROM PRODUTO
                           WHERE NOME LIKE CONCAT('%',P_PRODUTO,'%'))
    AND CODIGO NOT IN (SELECT SOLICITACAOALUGUEL_CODIGO FROM ALUGUEL);

END#
DELIMITER ;


DELIMITER #
    CREATE PROCEDURE SP_BUSCA_MEUSPRODUTOSALUGADOS(P_LOCATARIO INT, P_PRODUTO VARCHAR(255))
BEGIN    
    SELECT * FROM Aluguel
    WHERE solicitacaoAluguel_codigo IN (SELECT codigo
					FROM solicitacaoaluguel
                                        WHERE produto_codigo IN (SELECT codigo
								 FROM Produto
                                                                 WHERE Condomino_codigo = P_LOCATARIO
                                                                 AND nome LIKE CONCAT(P_PRODUTO,'%')))
    AND dataDevolucao IS NULL;
END#
DELIMITER ;