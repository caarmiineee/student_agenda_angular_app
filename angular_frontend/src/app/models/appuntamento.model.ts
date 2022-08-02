export class AppuntamentoRequest {
    id: number = -1;
    ora: number = 0;
    descrizione: string = "";
    data: string = "";
    agendaId: number = 0;
    tipologiaId: number = 0;
    ufficioId: number = 0;
}

export class AppuntamentoResponse {
    id: number = -1;
    ora: number = 0;
    descrizione: string = "";
    data: string = "";
    agendaNome: string = "";
    tipologiaNome: string = "";
    ufficioNome: string = "";
}