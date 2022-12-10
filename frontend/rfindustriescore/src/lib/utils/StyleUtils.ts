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
    headerHeight: "31px",
    headerBorderBottomColor: "#d3d3d3",
    menuBackColor: "#2f4050",
    menuFontColor: "white",
    menuBorderRightColor: "d3d3d3",
    bodyBackColor: "var(--appBackColor, white)",
    bodyFontColor: "var(--appFontColor, black)",
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

    .CoreButtons {
      float: left;
      height: 30px;
      width: 30px;
      border: none;
      cursor: pointer;
      background-color: transparent;
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
            height: var(--headerHeight, 31px);
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
            height: calc(100% - var(--headerHeight, 31px));
            min-width: 249px;
            max-width: 249px;
            float: left;
            background-color: var(--menuBackColor, #2f4050);
            color:  var(--menuFontColor, white);
            border-right: 1px solid var(--menuBorderRightColor, #d3d3d3);
            box-sizing: border-box;
        }

        .MenuComponentHidden {
          display: none;
        }

        .MenuComponentSearch{
          float: left;
          width: 100%;
          box-sizing: border-box;
          height = 31px;
        }

        .MenuComponentItems{
          float: left;
          width: 100%;
          box-sizing: border-box;
          height = calc(100% - 31px);
          overflow: auto;
        }
    </style>
    `;
}

export function cssMenuItemComponent(): string {
  return `
  <style>
    .MenuItemComponent {
      float: left;
      width: 100%;
      box-sizing: border-box;
      cursor: pointer;
    }

    .MenuItemComponentLabel{
      float: left;
      width: 100%;
      box-sizing: border-box;
    }

    .MenuItemComponentChild{
      float: left;
      width: 100%;
      box-sizing: border-box;
      cursor: pointer;
    }

    .MenuItemComponentChildLabel{
      float: left;
      width: 100%;
      box-sizing: border-box;
    }
  </style>
  `;
}

export function cssBodyComponent(): string {
  return `
    <style>
        .BodyComponent {
            margin: 0;
            padding: 0;
            height: calc(100% - var(--headerHeight, 31px));
            min-width: calc(100% - 249px);
            max-width: calc(100% - 249px);
            float: left;
            background-color: var(--bodyBackColor, #2f4050);
            color:  var(--bodyFontColor, white);
            box-sizing: border-box;
        }

        .BodyComponentFullScreen {
          min-width: 100%;
          max-width: 100%;
        }
    </style>
    `;
}
