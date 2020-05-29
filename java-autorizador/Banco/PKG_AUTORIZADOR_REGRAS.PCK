CREATE OR REPLACE PACKAGE AUTORIZADOR_REGRAS IS
-----------------------------------------------------------------------------------------
-- RETORNA FARMACIAS PELO COD FARM OU COD_FARM, COD_FILI
-----------------------------------------------------------------------------------------
PROCEDURE RET_FARM(P_COD_FARM  IN  TB_FARMACIA.COD_FARM%TYPE,
                   P_COD_FILI  IN  TB_FARMACIA.COD_FILI%TYPE,
                   P_FARMACIA  OUT SYS_REFCURSOR);

-----------------------------------------------------------------------------------------
-- RETORNA PLANO DE SAUDE
-----------------------------------------------------------------------------------------
PROCEDURE RET_PLAS(P_COD_PLAS  IN  TB_PLANO_SAUDE.COD_PLAS%TYPE,
                   P_PLAS      OUT SYS_REFCURSOR);

-----------------------------------------------------------------------------------------
-- RETORNA PRODUTOS POR NOME OU EAN
-----------------------------------------------------------------------------------------
PROCEDURE RET_PRODUTOS(P_EAN          IN  TB_FORNECEDOR.COD_EAN%TYPE,
                       P_NOME_PRODUTO IN  TB_PRODUTO.NOME_PROD%TYPE,
                       P_PRODUTOS     OUT SYS_REFCURSOR);

END AUTORIZADOR_REGRAS;
/
CREATE OR REPLACE PACKAGE BODY AUTORIZADOR_REGRAS IS

-----------------------------------------------------------------------------------------
-- RETORNA FARMACIAS PELO COD FARM OU COD_FARM, COD_FILI
-----------------------------------------------------------------------------------------
PROCEDURE RET_FARM(P_COD_FARM  IN  TB_FARMACIA.COD_FARM%TYPE,
                   P_COD_FILI  IN  TB_FARMACIA.COD_FILI%TYPE,
                   P_FARMACIA  OUT SYS_REFCURSOR) IS
BEGIN

    IF (P_COD_FARM IS NOT NULL) AND (P_COD_FILI IS NOT NULL) THEN
        OPEN P_FARMACIA FOR
            SELECT CNPJ_FARM,
                   NOME_FARM,
                   MATRIZ_FARM
             FROM TB_FARMACIA F
            WHERE F.COD_FARM = P_COD_FARM
              AND F.COD_FILI = P_COD_FILI
              AND F.DT_FIM > SYSDATE;
    ELSE
        OPEN P_FARMACIA FOR
            SELECT CNPJ_FARM,
                   NOME_FARM,
                   MATRIZ_FARM
             FROM TB_FARMACIA F
            WHERE F.COD_FARM = P_COD_FARM
              AND F.DT_FIM > SYSDATE;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ocorreu algum erro na busca da farmacia' || SQLERRM);
END RET_FARM;

-----------------------------------------------------------------------------------------
-- RETORNA PLANO DE SAUDE
-----------------------------------------------------------------------------------------
PROCEDURE RET_PLAS(P_COD_PLAS  IN  TB_PLANO_SAUDE.COD_PLAS%TYPE,
                   P_PLAS      OUT SYS_REFCURSOR) IS
BEGIN

    OPEN P_PLAS FOR
        SELECT PS.CNPJ_PLAS,
               PS.NOME_PLAS
         FROM TB_PLANO_SAUDE PS
        WHERE PS.COD_PLAS = P_COD_PLAS
          AND PS.DT_FIM > SYSDATE;

EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ocorreu algum erro na busca do plano de saude'|| SQLERRM);
END RET_PLAS;

-----------------------------------------------------------------------------------------
-- RETORNA PRODUTOS POR NOME OU EAN
-----------------------------------------------------------------------------------------
PROCEDURE RET_PRODUTOS(P_EAN          IN  TB_FORNECEDOR.COD_EAN%TYPE,
                       P_NOME_PRODUTO IN  TB_PRODUTO.NOME_PROD%TYPE,
                       P_PRODUTOS     OUT SYS_REFCURSOR) IS
BEGIN

    IF P_EAN <> 0 THEN
        OPEN P_PRODUTOS FOR
            SELECT P.COD_PROD,
                   P.NOME_PROD,
                   P.TP_PRODUTO
               FROM TB_PRODUTO     P,
                   TB_EAN_PRODUTO EP
               WHERE 1=1
               AND EP.COD_EAN = P_EAN
               AND EP.DT_FIM > SYSDATE
               AND P.COD_PROD = EP.COD_PROD
               AND P.DT_FIM > SYSDATE;
    ELSE
        OPEN P_PRODUTOS FOR
            SELECT P.COD_PROD,
                   P.NOME_PROD,
                   P.TP_PRODUTO 
              FROM TB_EAN_PRODUTO EP,
                   TB_PRODUTO     P 
             WHERE 1=1
               AND P.NOME_PROD LIKE'%'|| P_NOME_PRODUTO || '%'
               AND P.DT_FIM > SYSDATE
               AND EP.COD_PROD = P.COD_PROD
               AND EP.DT_FIM > SYSDATE;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ocorreu algum erro na busca do produto '|| SQLERRM);

END RET_PRODUTOS;

END AUTORIZADOR_REGRAS;
/
