import path from "node:path";
import { defineConfig } from "vite";

export default defineConfig({
  plugins: [],
  build: {
    lib: {
      entry: path.resolve(__dirname, "src/lib/index.ts"),
      name: "rfindustriescore",
      formats: ["es", "umd"],
      fileName: (format) => `rfindustriescore.${format}.js`,
    },
  },
});
