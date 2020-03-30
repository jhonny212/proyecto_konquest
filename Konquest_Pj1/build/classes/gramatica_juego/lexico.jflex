package gramatica_juego;
import java_cup.runtime.Symbol;
%%
%class lexico_juego
%cup
%cupdebug
%line
%column
%full
%char
%public
/*Identifiers*/
letra=[a-zA-z]
numero=[1-9]
cero=[0]
symbols=[$_-]
lineTerminator=[\t,\r]+
comilla=[\"]


%{
    public ArrayList<ErrorLexico> ErrorLexico;
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

%%

<YYINITIAL>{
    ","                                                         {return symbol(sym.coma,new String(yytext()));}
    "{"                                                         {return symbol(sym.abreParentesis,new String(yytext()));}                         
    "}"                                                         {return symbol(sym.cierraParentesis,new String(yytext()));}
    ":"                                                         {return symbol(sym.dosPuntos,new String(yytext()));}
    "MAPA"                                                      {return symbol(sym.map,new String(yytext()));}    
    "“"                                                         {return symbol(sym.abreComilla,new String(yytext()));}                
    "”"                                                         {return symbol(sym.cierraComilla,new String(yytext()));}
    "\""                                                        {return symbol(sym.Comilla,new String(yytext()));}
    "tamaño"                                                    {return symbol(sym.tamaño,new String(yytext()));}
    "columnas"                                                  {return symbol(sym.columns,new String(yytext()));}
    "filas"                                                     {return symbol(sym.rows,new String(yytext()));}                            
    "alAzar"                                                    {return symbol(sym.azar,new String(yytext()));}
    ("true")|("false")                                          {return symbol(sym.bool,new String(yytext()));}
    "planetasNeutrales"                                         {return symbol(sym.planetasNeu,new String(yytext()));}
    "mapaCiego"                                                 {return symbol(sym.mapaCiego,new String(yytext()));}
    "acumular"                                                  {return symbol(sym.acum,new String(yytext()));}
    "NEUTRALES"                                                 {return symbol(sym.Neu,new String(yytext()));}            
    "mostrarNaves"                                              {return symbol(sym.mostrarNaves,new String(yytext()));}
    "mostrarEstadisticas"                                       {return symbol(sym.mostrarEstadisticas,new String(yytext()));}
    "produccion"                                                {return symbol(sym.produc,new String(yytext()));}
    "finalizacion"                                              {return symbol(sym.end,new String(yytext()));}    
    "id"                                                        {return symbol(sym.name_mapa,new String(yytext()));}         
    "PLANETAS"                                                  {return symbol(sym.planets,new String(yytext()));}
    "nombre"                                                    {return symbol(sym.name,new String(yytext()));}
    "naves"                                                     {return symbol(sym.ships,new String(yytext()));}
    "porcentajeMuertes"                                         {return symbol(sym.deaths,new String(yytext()));}        
    
    "PLANETAS_NEUTRALES"                                        {return symbol(sym.planetas_Neu,new String(yytext()));}
    
    "JUGADORES"                                                 {return symbol(sym.players,new String(yytext()));}                
    "planetas"                                                  {return symbol(sym.earths,new String(yytext()));}
    "["                                                         {return symbol(sym.abreCor,new String(yytext()));}    
    "]"                                                         {return symbol(sym.cierraCor,new String(yytext()));}
    "tipo"                                                      {return symbol(sym.type,new String(yytext()));}    
    "HUMANO"                                                    {return symbol(sym.human,new String(yytext()));}    
    "DIFICIL"                                                   {return symbol(sym.hard,new String(yytext()));}    
    "FACIL"                                                     {return symbol(sym.easy,new String(yytext()));}
    (({numero}|{cero})({numero}|{cero})*)                       {return symbol(sym.num,new String(yytext()));}    
    ({cero}+(".")({cero}|{numero})*)                            {return symbol(sym.decimal,new String(yytext()));}    
    ({letra}|{symbols})({letra}|{symbols}|{numero}|{cero})*     {return symbol(sym.id,new String(yytext()));}
    ("\n")|("\t")                                               {/*return symbol(sym.enter,new String(yytext()));*/ }
    
    (" ")                                                      {/*return symbol(sym.space,new String(yytext()));*/}
    .                                                          {

ErrorLexico.add(new ErrorLexico(yytext(),yyline(),yycolumn())) ;   
return symbol(sym.ERROR,new String(yytext()));}         
}