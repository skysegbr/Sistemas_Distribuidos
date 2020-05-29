CREATE OR REPLACE PACKAGE BODY AUTORIZADOR_REGRAS IS

-----------------------------------------------------------------------------------------
-- RETORNA FARMACIAS PELO COD FARM OU COD_FARM, COD_FILI
-----------------------------------------------------------------------------------------
PROCEDURE RET_FARM(P_COD_FARM  IN  TB_FARMACIA.COD_FARM%TYPE,
                   P_COD_FILI  IN  TB_FARMACIA.COD_FILI%TYPE
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
              AND F.TD_FIM > SYSDATE;
    ELSE
        OPEN P_FARMACIA FOR
            SELECT CNPJ_FARM,
                   NOME_FARM,
                   MATRIZ_FARM
             FROM TB_FARMACIA F
            WHERE F.COD_FARM = P_COD_FARM
              AND F.TD_FIM > SYSDATE;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ocorreu algum erro na busca da farmacia' || SQLERRM);
END RET_FARM;

-----------------------------------------------------------------------------------------
-- RETORNA PLANO DE SAUDE
-----------------------------------------------------------------------------------------
PROCEDURE RET_PLAS(P_COD_PLAS  IN  TB_PLANO_SAUDE%TYPE,
                   P_PLAS      OUT SYS_REFCURSOR) IS
BEGIN

    OPEN P_PLAS FOR
        SELECT PS.CNPJ_PLAS,
               PS.NOME_PLAS
         FROM TB_PLANO_SAUDE PS
        WHERE PS.COD_PLAS = P_COD_PLAS
          AND F.TD_FIM > SYSDATE;

EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ocorreu algum erro na busca do plano de saude' || SQLERRM);
END RET_PLAS;



END AUTORIZADOR_REGRAS;