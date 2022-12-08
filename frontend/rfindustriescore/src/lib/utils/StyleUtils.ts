import { CssVarProps } from "../features/CssVarProps";
import { isNotNull } from "./CommonUtils";

export function defaultCssVarsProps(): CssVarProps {
  return {
    appFontFamily: " Open Sans",
    appBackColor: "white",
    appSecondaryBackColor: "white",
    appFontColor: "black",
    headerBackColor: "var(--appBackColor, white)",
    headerFontColor: "var(--appFontColor, black)",
    headerBorderBottomColor: "#d3d3d3",
    menuBackColor: "#2f4050",
    menuFontColor: "white",
    menuBorderRightColor: "d3d3d3",
  } as CssVarProps;
}

export function cssVars(
  cssVarPropos: CssVarProps = defaultCssVarsProps(),
  otherProps?: { [key: string]: string }
): string {
  let builder = `<style> `;
  builder = builder + " :root { ";
  let anyCssVarprops: any = cssVarPropos;

  if (isNotNull(otherProps)) {
    for (const key in otherProps) {
      anyCssVarprops[key] = otherProps[key];
    }
  }

  for (const key in cssVarPropos) {
    builder = builder + " --" + key + ":" + anyCssVarprops[key] + "; ";
  }

  builder = builder + " } ";

  builder = builder + cssCore();

  builder = builder + " </style>";

  return builder;
}

function cssCore(): string {
  return `
    body, html, #app, #App {
        font-family: var(--appFontFamily);
        margin: 0;
        padding: 0;
        height: 100%;
        width: 100%;
        float: left;
        color:  var(--appFontColor, black);
        box-sizing: border-box;
    } 
  `;
}

export function cssAppComponent(): string {
  return `
    <style>
        .AppComponent {
            margin: 0;
            padding: 0;
            height: 100%;
            width: 100%;
            float: left;
            background-color: var(--appBackColor, white);
            color:  var(--appFontColor, black);
            box-sizing: border-box;
        }
    </style>
    `;
}

export function cssHeaderComponent(): string {
  return `
    <style>
        .HeaderComponent {
            margin: 0;
            padding: 0;
            height: 40px;
            width: 100%;
            float: left;
            background-color: var(--headerBackColor, white);
            color:  var(--headerFontColor, black);
            border-bottom: 1px solid var(--headerBorderBottomColor, #d3d3d3);
            box-sizing: border-box;
        }
    </style>
    `;
}

export function cssMenuComponent(): string {
  return `
    <style>
        .MenuComponent {
            margin: 0;
            padding: 0;
            height: calc(100% - 40px);
            min-width: 249px;
            max-width: 249px;
            float: left;
            background-color: var(--menuBackColor, #2f4050);
            color:  var(--menuFontColor, white);
            border-right: 1px solid var(--menuBorderRightColor, #d3d3d3);
            box-sizing: border-box;
        }
    </style>
    `;
}
