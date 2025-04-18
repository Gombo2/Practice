import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  server: {
    proxy: {
      '/api': {
        /* 1. 7777일때 : 백엔드가 컨테이너화 되기 전(8055:7777) */
        // target: 'http://localhost:7777',

        /* 2. 백엔드가 컨테이너화 됨(8055:7777)*/
        target: 'http://localhost:8055',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})
