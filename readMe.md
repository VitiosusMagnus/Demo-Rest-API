[Link For Live Website](https://vitiosusmagnus-demo-app.azurewebsites.net/)

## Next.js Dependencies
The project utilizes several dependencies, including:

- **@ant-design/cssinjs:** Styling solution for Ant Design components.
- **@headlessui/react:** React components for building accessible and composable user interfaces.
- **@heroicons/react:** A set of free MIT-licensed high-quality SVG icons.
- **@radix-ui/react-menubar:** A highly customizable menubar component.
- **@tanstack/react-table:** A table library for React.
- **antd:** A React UI library with a set of high-quality components.
- **axios:** A promise-based HTTP client for the browser and Node.js.
- **lucide-react:** A collection of simply designed, open-source SVG icons.
- **next:** The Next.js framework for React applications.
- **react:** The React library for building user interfaces.
- **tailwindcss-animate:** Tailwind CSS plugin for adding animation classes.

## Next.js Development Scripts
The project includes various npm scripts for development, building, and linting:

- **dev:** Run the development server.
- **build:** Build the application for production.
- **start:** Start the production server.
- **lint:** Run linting using Next.js configurations.

## Front-end Implementation
The main page (`Page.tsx`) imports and utilizes several components:

- **Menubar:** A custom menubar component for navigating through the application.
- **Table:** A custom table component for displaying movie details.

The page fetches movie data from an external API (`https://vitiosusmagnus-demo-app.azurewebsites.net/api/film`) using Axios. The fetched data is then displayed in a table format. The page also includes a header and footer for branding and attribution.

## Styling
Styling is achieved using Tailwind CSS, with classes applied directly in the JSX for a concise and maintainable styling approach.

## Usage
To run the application locally, use the following commands:

```javascript
npm install       # Install dependencies
npm run dev       # Run the development server
```

## Contributors
The application was developed by Furkancan Okal and Mehmet Ozgul.
