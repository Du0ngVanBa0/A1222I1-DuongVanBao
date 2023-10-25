let courses = [
    {
        id: 1,
        title: "ReactJS Tutorial",
        rating: 4.2
    },
    {
        id: 2,
        title: "Angular Tutorial",
        rating: 2.5
    },
    {
        id: 3,
        title: "VueJS Tutorial",
        rating: 3.8
    },
    {
        id: 4,
        title: "Java Tutorial",
        rating: 4
    },
    {
        id: 5,
        title: "JavaScript Tutorial",
        rating: 3.5
    },
];

let addedCourse = [
    {
        id: 6,
        title: "PHP Tutorial",
        rating: 4
    },
    {
        id: 7,
        title: "C# Tutorial",
        rating: 4
    },
    {
        id: 8,
        title: "Docker Tutorial",
        rating: 4
    },
]

console.log(courses.filter(value => value.rating >= 4));
console.log(courses.map(value => {
    if (value.rating < 4) {
        return value.id + "-" + value.title + "-" + value.rating;
    }
}));
let mergeArr = [...courses, ...addedCourse];
console.log(mergeArr)