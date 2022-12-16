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
    menuFontColor: "#d1d5db",
    menuBorderRightColor: "d3d3d3",
    bodyBackColor: "var(--appBackColor, white)",
    bodyFontColor: "var(--appFontColor, black)",
    tabViewHeaderItemActiveBackColor: "#2f4050",
    tabViewHeaderItemActiveFontColor: "white",
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
   * {
      box-sizing: border-box;
      -webkit-user-select: none; /* Safari */
      -ms-user-select: none; /* IE 10 and IE 11 */
      user-select: none; /* Standard syntax */
   }

   
  input {
    outline: none !important;
  }
   
  body, html, #app, #App {
      font-family: var(--appFontFamily);
      margin: 0;
      padding: 0;
      height: 100%;
      width: 100%;
      float: left;
      color:  var(--appFontColor, black);
  } 

  .CoreButtons {
    float: left;
    height: 30px;
    width: 30px;
    border: none;
    cursor: pointer;
    background-color: transparent;
  }

  .IFrameBody{
    border: none;
    height: 100%;
    width: 100%;
    float: left;
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
        }

        .HeaderComponentLeft{
          float:left;
          min-width: 249px;
          max-width: 249px;
        }
        .HeaderComponentMiddle{
          float:left;
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
            font-weight: 600;
        }

        .MenuComponentHidden {
          display: none;
        }

        .MenuComponentSearch{
          float: left;
          width: 100%;
          height : 31px;
        }

        .MenuComponentSearchInput{
          margin: 10px;
          width: 90%;
          border-radius: 10px;
          padding-left: 13px;
        }

        .MenuComponentItems{
          float: left;
          width: 100%;
          height: calc(100% - 31px);
          overflow: auto;
          padding-top: 10px;
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
      cursor: pointer;
      padding-top: 10px;
      border-bottom: 1px solid var(--menuFontColor, white);
      padding-bottom: 5px;
    }

    .MenuItemComponentLabel{
      float: left;
      width: calc(100% - 10px);
      padding-left: 10px;
      font-size: 18px;
    }

    .MenuItemComponentChidls{
      float: left;
      width: 100%;
    }

    .MenuItemComponentChild{
      float: left;
      width: 100%;
      cursor: pointer;
      margin-top: 5px;
      margin-bottom: 5px
    }

    .MenuItemComponentChildLabel{
      float: left;
      width: calc(100% - 30px);
      padding-left: 20px;
      font-size: 14px;
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
        }

        .BodyComponentFullScreen {
          min-width: 100%;
          max-width: 100%;
        }
    </style>
    `;
}

export function cssTabViewComponent(): string {
  return `
    <style>
      .TabViewComponent {
        float: left;
        width: 100%;
        height: 100%;
      }
    
      .TabViewComponentHeaders {
        float: left;
        width: 100%;
        height : 31px;
      }
    
      .TabViewComponentHeader {
        float: left;
        height : 100%;
        padding: 5px;
        padding-right: 10px;
        padding-left: 10px;
        text-align: center;
      }
    
      .TabViewComponentHeaderActive {
        border-radius: 0 9px 0 0;
        background: var(--tabViewHeaderItemActiveBackColor, black);
        color: var(--tabViewHeaderItemActiveFontColor, white);
      }

      .TabViewComponentHeaderTitle{
        float: left;
        cursor: pointer;
      }

      .TabViewComponentHeaderIcon{
        float: left;
        margin-left: 6px;
        font-size: 12px;
        cursor: pointer;
      }
      
      .TabViewComponentBodys {
        float: left;
        width: 100%;
        height : calc(100% - 31px);
      }
    
      .TabViewComponentBody {
        float: left;
        width: 100%;
        height: 100%;
        display: none;
        border-top: 1px solid var(--tabViewHeaderItemActiveBackColor, transparent);
      }
    
      .TabViewComponentBodyActive {
        display: block;
      }
    </style>
    `;
}
