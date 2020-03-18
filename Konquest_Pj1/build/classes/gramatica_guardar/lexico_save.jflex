package gramatica_guardar;
import java_cup.runtime.Symbol;
%%
%class lexico_save
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
lineTerminator=[\t,\r]

%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}
%%
<YYINITIAL>{
    "["             {return symbol(sym.abreCor,new String(yytext()));}
    "]"             {return symbol(sym.cierraCor,new String(yytext()));}
    "{"             {return symbol(sym.abreParen,new String(yytext()));}
    "}"             {return symbol(sym.cierraParen,new String(yytext()));}
    "mapa"          {return symbol(sym.mapa,new String(yytext()));}
    "color"         {return symbol(sym.color,new String(yytext()));}
    "rojo"          {return symbol(sym.rojo,new String(yytext()));}
    "azul"          {return symbol(sym.azul,new String(yytext()));}
    "verde"         {return symbol(sym.verde,new String(yytext()));}
    "dimensiones"   {return symbol(sym.dimensiones,new String(yytext()));}
    ":"             {return symbol(sym.dosPuntos,new String(yytext()));}
    "filas"         {return symbol(sym.filas,new String(yytext()));}
    "columnas"      {return symbol(sym.columnas,new String(yytext()));}
    "azar"          {return symbol(sym.azar,new String(yytext()));}
    "mapaciego"     {return symbol(sym.mapaCiego,new String(yytext()));}
    "acumular"      {return symbol(sym.acumular,new String(yytext()));}
    "neutrales"     {return symbol(sym.neutrales,new String(yytext()));}
    "naves"         {return symbol(sym.naves,new String(yytext()));}
    "estadisticas"  {return symbol(sym.estadisticas,new String(yytext()));}
    "planetas"      {return symbol(sym.planetas,new String(yytext()));}
    "neutral"       {return symbol(sym.neutral,new String(yytext()));}
    "nombre"        {return symbol(sym.nombre,new String(yytext()));}
    "produccion"    {return symbol(sym.produccion,new String(yytext()));}    
    "muertes"       {return symbol(sym.muertes,new String(yytext()));}
    "posicion"      {return symbol(sym.pos,new String(yytext()));}
    "coord_x"       {return symbol(sym.x,new String(yytext()));}
    "coord_y"       {return symbol(sym.y,new String(yytext()));}
    "jugadores"     {return symbol(sym.jugadores,new String(yytext()));}
    "tipo"          {return symbol(sym.tipo,new String(yytext()));}
    ("true")|("false")                                          {return symbol(sym.bool,new String(yytext()));}
    (({numero}|{cero})({numero}|{cero})*)                       {return symbol(sym.num,new String(yytext()));}    
    ({cero}+(".")({cero}|{numero})*)                            {return symbol(sym.decimal,new String(yytext()));}    
    ({letra}|{symbols})({letra}|{symbols}|{numero}|{cero})*     {return symbol(sym.id,new String(yytext()));}
    ("\n")|("\t")                                               {return symbol(sym.enter,new String(yytext()));}
    (" ")                                                       {return symbol(sym.space,new String(yytext()));}
    .                                                           {return symbol(sym.ERROR,new String(yytext()));}    

}