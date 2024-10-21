Team Reflection for Crop Pest Management System Project
Design

How closely did you follow your design document after the review was complete? Did your implementation need to change based on what you learned once you were underway?

I followed the design document fairly closely after the initial review. The overall architecture and data flow between the frontend and backend were as planned. However, some adjustments were made as the implementation progressed. For instance, the integration between AWS Lambda, API Gateway, and DynamoDB needed refinements due to unforeseen complexities like managing CORS issues and handling edge cases in data validation. These adjustments didn’t drastically change the design but enhanced its reliability and performance.
Project

How did you handle ambiguity and user stories? What strategies did you use to decide on concrete work to satisfy your requirements?

Since I was the sole developer, I took a methodical approach to handle ambiguity by breaking down the user stories into smaller, actionable tasks. I prioritized tasks that delivered the core functionality first, such as adding, updating, and retrieving pests. To clarify uncertainties, I frequently revisited the design document and user requirements, ensuring each decision aligned with the overall goal of providing an intuitive and scalable pest management system. I also maintained a flexible mindset, allowing the requirements to evolve naturally as I progressed.

How did you deal with getting stuck on a problem? What strategies did you employ to get yourself unblocked?

When I got stuck on complex issues—such as resolving cross-origin requests or debugging AWS IAM roles—I used several strategies to get unstuck. First, I broke the problem down into smaller components to isolate the root cause. I also leveraged online resources, documentation, and developer forums. When necessary, I took breaks to clear my mind before returning to the problem with a fresh perspective. This helped prevent frustration and allowed me to approach the problem more effectively.
Scrum

What did you find to be the most valuable part of daily stand-ups? Is there anything you would want to do differently at stand-up to make it more useful to you?

Even though I was working alone, I adopted a self-checking "stand-up" routine where I reviewed what I had completed the previous day and set specific goals for the day ahead. This informal daily reflection helped me stay organized and track progress. If I were working in a team, I would use stand-ups as a time to align tasks and quickly identify blockers. Moving forward, I would experiment with adding brief retrospective notes at the end of each day to identify what could be improved during the next work cycle.

Did you over or underestimate the work you could complete during your sprints? What have you learned that will help you better estimate work next time?

I slightly underestimated the complexity of integrating the frontend with the serverless backend and managing AWS configurations. This added time to my sprints that I didn’t initially account for. In future projects, I’ll allocate more time to research and preparation, especially for technologies that require complex configurations like AWS services. Additionally, I’ll make sure to set more realistic expectations about the time needed for debugging and testing.
Looking Ahead

What would you do differently if you were to start this unit over again? How do you see yourself applying that to your work in later units, the capstone, or your internship?

If I were to start this project over again, I would invest more time upfront in learning the finer details of AWS services, such as configuring IAM roles and permissions. I would also adopt a more structured testing approach, setting up tests earlier in the development cycle. Moving forward, I will carry these lessons into future projects, especially during my capstone or internship, where time management and efficient problem-solving will be key. Furthermore, I plan to improve my estimations by being more mindful of potential challenges, allowing for additional buffer time during sprints