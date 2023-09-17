# Use the official Node.js image from Docker Hub
FROM node:16 as build-stage-1

# Set the working directory in the container
WORKDIR /usr/app

# Copy package.json and package-lock.json before other files
# Utilize Docker cache to save re-installing dependencies if unchanged
COPY ./frontend/package.json ./frontend/package-lock.json ./
RUN npm install

# Copy all files from your frontend project into the container
COPY ./frontend ./

# Build the Next.js app for production
# RUN npm run dev

# Expose the port your application will listen on (adjust as needed)
EXPOSE 3000

# Command to start your application when the container starts
CMD ["npm", "start"]
